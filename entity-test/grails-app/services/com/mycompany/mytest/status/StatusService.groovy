package com.mycompany.mytest.status

import grails.gorm.transactions.Transactional
import groovy.sql.GroovyRowResult
import groovy.sql.Sql
import org.grails.datastore.mapping.query.api.Criteria

@Transactional
class StatusService {

    def dataSource

    public StatusEnt createStatus(String ownerId, String statusId, String reasonId, String transactionId, Date startDate = null){
        if(!startDate){
            startDate = new Date()
        }

        StatusEnt inBetweenStatus = getStatusCoveringDate(ownerId,startDate);
        StatusEnt nextStatus = getNextStatusAfterDate(ownerId,startDate);

        if(inBetweenStatus){
            inBetweenStatus.setEndDate(startDate);
            inBetweenStatus.save(failOnError:true)
        }

        StatusEnt newStatus = new StatusEnt();
        newStatus.ownerId = ownerId;
        newStatus.reasonId = reasonId;
        newStatus.transactionId = transactionId;
        newStatus.startDate = startDate;
        newStatus.statusId = statusId;

        if(nextStatus){
            newStatus.endDate = nextStatus.startDate;
        }

        newStatus.save(failOnError:true)

        return newStatus;
    }

    @Transactional(readOnly = true)
    public StatusEnt getCurrentStatus(String ownerId){

        final Date currentDate = new Date()
        Criteria criteria = StatusEnt.createCriteria()
        StatusEnt currentStatus = (StatusEnt)criteria.get {
            eq("ownerId", ownerId)
            and{
                lt("startDate",currentDate)
                or {
                    gt("endDate",currentDate)
                    isNull("endDate")
                }
            }
            cache(false)
        }

        // NORMAL CODE ENDS HERE - THESE ARE SOME PARANOID CHECKS WHICH REVEAL THE ISSUE WITH PRINTS
        if (currentStatus == null) {
            Sql sql = Sql.newInstance(dataSource)
            List<Object> params = [ownerId]
            List<GroovyRowResult> results = sql.rows("Select id from status where owner_id = ?;", params)
            if (results.size() > 0) {
                println "TEST: THERE IS A RESULT EVEN THOUGH CRITERIA SAID NULL"
            } else {
                // WHEN IT FAILS, IT WILL HIT HERE
                println "TEST: THERE IS NO ROW FOR OWNER_ID ${ownerId}, BUT IT WILL APPEAR IN THE DB AFTER THIS PRINT"
            }
        }

        return currentStatus
    }

    @Transactional(readOnly = true)
    private StatusEnt getStatusCoveringDate(String ownerId,Date date){
        List<StatusEnt> statuses = StatusEnt.findAllByOwnerId(ownerId,[sort:'startDate']);
        for(StatusEnt status : statuses){
            if(status.getStartDate() < date && (status.getEndDate() == null || status.getEndDate() > date)){
                return status;
            }
        }
        return null;
    }

    @Transactional(readOnly = true)
    private StatusEnt getNextStatusAfterDate(String ownerId,Date date){
        List<StatusEnt> statuses = StatusEnt.findAllByOwnerId(ownerId,[sort:'startDate']);
        for(StatusEnt status : statuses){
            if(status.getStartDate() > date){
                return status;
            }
        }
        return null
    }

    @Transactional(readOnly = true)
    public StatusEnt getStatusById(String id){
        return StatusEnt.get(id)
    }

    public boolean isActive(String id){
        if(id) {
            StatusService statusService = this// (StatusService)Holders.getGrailsApplication().getMainContext().getBean("statusService");
            StatusEnt status = statusService.getCurrentStatus(id)
            return "ACTIVE".equals(status.getStatusId())
        }else{
            return false
        }
    }

}


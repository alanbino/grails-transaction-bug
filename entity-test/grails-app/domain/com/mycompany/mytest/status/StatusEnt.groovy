package com.mycompany.mytest.status

class StatusEnt {

    static mapping = {
        table 'status'
        id generator:'uuid', length:39
    }

    String id
    String ownerId
    String statusId
    String reasonId
    String transactionId
    Date dateCreated
    Date lastUpdated
    Date startDate
    Date endDate

    static constraints = {
        endDate nullable: true
        transactionId nullable: true
        reasonId nullable: true
    }
}

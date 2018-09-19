package entity.test

import com.mycompany.mytest.status.StatusService
import grails.gorm.transactions.Transactional

@Transactional
class EntityTestService {

    StatusService statusService

    String setUp() {

        ChecklistEnt cle = new ChecklistEnt()
        cle.active = true
        cle.somethingElse = "something"
        cle.lastUpdated = new Date()
        cle.dateCreated = new Date()

        ChecklistLabelEnt clle1 = new ChecklistLabelEnt()
        clle1.label = "this is a label 1"
        clle1.lastUpdated = new Date()
        clle1.dateCreated = new Date()
        clle1.save()

        ChecklistLabelEnt clle2 = new ChecklistLabelEnt()
        clle2.label = "this is a label 2"
        clle2.lastUpdated = new Date()
        clle2.dateCreated = new Date()
        clle2.save()

        cle.addToLabels(clle1)
        cle.addToLabels(clle2)

        cle.save()

        statusService.createStatus(cle.id, "ACTIVE", null, null, new Date())

        return cle.id

    }

    @Transactional(readOnly = true)
    ChecklistEnt findCheckList(String checklistId) {
        return ChecklistEnt.get(checklistId)
    }

}

package entity.test

import grails.converters.JSON

class EntityTestController {

    def entityTestService

    def setUp() {

        String checklistId = entityTestService.setUp()
        forward( action: "findChecklist", params:[ checklistId: checklistId ] )
    }

    def findChecklist() {

        String checklistId = (String)params.checklistId
        ChecklistEnt checklistEnt = entityTestService.findCheckList(checklistId)
        JSON responseBody = ChecklistConverter.getChecklistJSON(checklistEnt)
        render "SUCCESS! TRY AGAIN FOR FAILURE!"
    }
}

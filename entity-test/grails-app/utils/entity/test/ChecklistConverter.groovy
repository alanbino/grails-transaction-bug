package entity.test

import com.mycompany.mytest.status.StatusService
import grails.converters.JSON

class ChecklistConverter {

    public static JSON getChecklistJSON(ChecklistEnt checklistEnt) {

        boolean statusActive = StatusService.isActive(checklistEnt.id)

        return [
                id : checklistEnt.id,
                dateCreated : checklistEnt.dateCreated,
                lastUpdated : checklistEnt.lastUpdated,
                active : checklistEnt.active,
                statusActive : statusActive,
                somethingElse : checklistEnt.somethingElse,
                labels:checklistEnt.labels.collect() { labelEnt ->
                    [
                            id : checklistEnt.id,
                            label : labelEnt.label,
                            dateCreated: labelEnt.dateCreated,
                            lastUpdated: labelEnt.lastUpdated
                    ]
                }
        ] as JSON
    }

}

package entity.test

class ChecklistLabelEnt {

    String id

    Date dateCreated
    Date lastUpdated

    static mapping = {
        table 'cli_checklist_labels'
        id generator:'uuid'
        version true
    }

    static constraints = {
        label nullable:false
    }

    String label

}

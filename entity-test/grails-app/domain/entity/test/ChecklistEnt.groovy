package entity.test

/**
 * @author Patrick
 */
class ChecklistEnt {

    Date dateCreated
    Date lastUpdated

    String id

    boolean active

    String somethingElse

    static hasMany = [
            labels:ChecklistLabelEnt
    ]

    static mapping = {
        table 'cli_checklist'
        id generator:'uuid'
        version true
        labels : cascade: 'all-delete-orphan'
    }

}


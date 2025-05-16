package seg3102.group25.wellmeadows.hmspms.contracts.testStubs.repositories

import seg3102.group25.wellmeadows.hmspms.domain.staff.entities.account.StaffAccount
import seg3102.group25.wellmeadows.hmspms.domain.staff.repositories.StaffAccountRepository
import seg3102.group25.wellmeadows.hmspms.domain.staff.valueObjects.StaffType
import seg3102.group25.wellmeadows.hmspms.infrastructure.web.forms.actions.StaffShiftForm

class StaffAccountRepositoryStub : StaffAccountRepository {
    override suspend fun find(employeeNumber: String): StaffAccount? {
        return StaffAccount("", "", "", "", "")
    }

    override fun save(staffAccount: StaffAccount): StaffAccount {
        return StaffAccount("", "", "", "", "")
    }

    override fun findSync(employeeNumber: String): StaffAccount? {
        return null
    }

    override fun saveRoles(employeeID: String, roles: StaffType?): Boolean {
        TODO("Not yet implemented")
    }

    override fun saveDivisions(staffShiftForm: StaffShiftForm): Boolean {
        TODO("Not yet implemented")
    }
}
package ru.malis.lifehackcompanies.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import ru.malis.lifehackcompanies.R
import ru.malis.core_style.R as style

object Routes {

    fun Fragment.navigateToCompanyDetails(companyId: Int) {

    }

    fun Fragment.popBackStack() {
        parentFragmentManager.popBackStack()
    }

    private fun FragmentTransaction.setupTransaction(fragment: Fragment): FragmentTransaction {
        this.setCustomAnimations(
            style.anim.enter_right_to_left, //enter
            style.anim.exit_right_to_left, //exit
            style.anim.enter_left_to_right, //popEnter
            style.anim.exit_left_to_right //popExit
        )
        this.setReorderingAllowed(true)
        this.replace(R.id.fragment_container_view, fragment)

        return this
    }
}
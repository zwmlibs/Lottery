package com.baixun.lottery.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.view.Gravity
import android.view.MenuItem
import com.baixun.lottery.R
import com.baixun.lottery.base.BaseFragment
import com.baixun.lottery.base.BaseFragmentPagerAdapter
import com.baixun.lottery.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var mainAdapter : BaseFragmentPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init (){
        setupDrawerContent(navigationView)
        var homeFragment = HomeFragment()
        val fragments = ArrayList<Fragment>()
        fragments.add(homeFragment)
        //mainAdapter = BaseFragmentPagerAdapter(homeFragment,supportFragmentManager)

        val fragmentTransaction = supportFragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frameContent,homeFragment).commit()

    }

    private fun setupDrawerContent(navigationView: NavigationView) {
        navigationView.setNavigationItemSelectedListener { menuItem ->
            switchNavigation(menuItem.itemId)
            menuItem.isChecked = true
            drawerLayout.closeDrawers()
            true
        }
    }

    public fun openMenu(){
        drawerLayout.openDrawer(Gravity.START)
    }

    private fun switchNavigation(id : Int){

    }
}

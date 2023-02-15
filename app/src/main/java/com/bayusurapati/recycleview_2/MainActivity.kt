package com.bayusurapati.recycleview_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT INTENT"
    }

    private var title: String = "Mode List"

    private lateinit var rvHeroes: RecyclerView
    private var list: ArrayList<TF2CLASS> = arrayListOf()
    lateinit var listHeroAdapter: ListTF2Adapter
    lateinit var gridHeroAdapter: GridTF2Adapter
    lateinit var cardHeroAdapter: CardTF2Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHeroes = findViewById(R.id.rv_hero)
        rvHeroes.setHasFixedSize(true)

        list.addAll(TF2Data.listData)
        showRecycleList()
    }


    private fun showRecycleList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        listHeroAdapter = ListTF2Adapter(list)
        gridHeroAdapter = GridTF2Adapter(list)
        cardHeroAdapter = CardTF2Adapter(list)
        rvHeroes.adapter = listHeroAdapter
        setActionBarTitle(title)
    }
    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                title = "Mode List"
                rvHeroes.layoutManager = LinearLayoutManager(this)
                rvHeroes.adapter = listHeroAdapter
            }
            R.id.action_grid -> {
                title = "Mode Grid"
                setActionBarTitle(title)
                rvHeroes.layoutManager = GridLayoutManager(this, 2)
                rvHeroes.adapter = gridHeroAdapter
            }
            R.id.action_cardView -> {
                title = "Mode Card View"
                setActionBarTitle(title)
                rvHeroes.layoutManager = LinearLayoutManager(this)
                rvHeroes.adapter = cardHeroAdapter
            }
        }
    }
}


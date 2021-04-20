package com.infosys.recyclerviewmvvm.ui

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infosys.recyclerviewmvvm.R
import com.infosys.recyclerviewmvvm.modelNew.ItemRow

class LiveDataMVVM : ViewModel() {
    private var itemList: MutableLiveData<ArrayList<ItemRow>>? = null

    internal fun getItemList(): MutableLiveData<ArrayList<ItemRow>> {
        if (itemList == null) {
            itemList = MutableLiveData()
            loadItems()
        }
        return itemList as MutableLiveData<ArrayList<ItemRow>>
    }

    private fun loadItems() {
        // do async operation to fetch users
        val myHandler = Handler()
        myHandler.postDelayed({
            val itemsList = ArrayList<ItemRow>()

            itemsList.add(
                ItemRow(
                    "Beavers",
                    "Beavers are second only to humans in their ability to manipulate and change their environment." +
                            " They can measure up to 1.3 metres long. A group of beavers is called a colony",
                    R.drawable.eilat_dolphin_reef
                )
            )
            itemsList.add(
                ItemRow(
                    "Flag", "null",
                    R.drawable.eilat_dolphin_reef
                )
            )
            itemsList.add(
                ItemRow(
                    "Transportation",
                    "It is a well known fact that polar bears are the main mode of transportation in Canada. They consume far less gas and have the added benefit of being difficult to steal.",
                    R.drawable.eilat_dolphin_reef
                )
            )
            itemsList.add(
                ItemRow(
                    "Hockey Night in Canada",
                    "These Saturday night CBC broadcasts originally aired on radio in 1931. In 1952 they debuted on television and continue to unite (and divide) " +
                            "the nation each week.",
                    R.drawable.eilat_dolphin_reef
                )
            )
            itemsList.add(
                ItemRow(
                    "Eh",
                    "A chiefly Canadian interrogative utterance, usually expressing surprise or doubt or seeking confirmation.",
                    0
                )
            )
            itemsList.add(
                ItemRow(
                    "Housing",
                    "Warmer than you might think.",
                    R.drawable.igloo
                )
            )
            itemsList.add(
                ItemRow(
                    "Public Shame",
                    "Warmer than you might think.",
                    R.drawable.man
                )
            )
            itemsList.add(
                ItemRow(
                    "null",
                    "null",
                    0
                )
            )
            itemsList.add(
                ItemRow(
                    "Space Program",
                    "Canada hopes to soon launch a man to the moon.",
                    R.drawable.animal
                )
            )
            itemsList.add(
                ItemRow(
                    "Meese",
                    "A moose is a common sight in Canada. " +
                            "Tall and majestic, they represent many of the values which Canadians imagine that they possess." +
                            " They grow up to 2.7 metres long and can weigh over 700 kg. They swim at 10 km/h. Moose antlers weigh roughly 20 kg. The plural of moose is actually" +
                            " 'meese', despite what most dictionaries, encyclopedias, and experts will tell you.",
                    R.drawable.animal
                )
            )
            itemsList.add(
                ItemRow(
                    "Geography",
                    "It's really big.",
                    0
                )
            )
            itemsList.add(
                ItemRow(
                    "Kittens",
                    "Éare illegal. Cats are fine.",
                    R.drawable.animal
                )
            )
            itemsList.add(
                ItemRow(
                    "Mounties",
                    "They are the law. They are also Canada's foreign espionage service. Subtle.",
                    R.drawable.animal
                )
            )
            itemsList.add(
                ItemRow(
                    "Language",
                    "Nous parlons tous les langues importants.",
                    0
                )
            )
            itemList!!.postValue(itemsList)//for background postValue

        }, 2000)

    }


}
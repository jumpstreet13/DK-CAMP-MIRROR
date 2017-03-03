package com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser;


import com.smedialink.abakarmagomedov.dk_camp_mirror.R;
import com.smedialink.abakarmagomedov.dk_camp_mirror.models.OpleveslerItem;

import java.util.ArrayList;
import java.util.List;

public class OplevelserActivityFirstInteractor implements OplevelserActivityInteractor {
    @Override
    public List<OpleveslerItem> getFakeData() {
        OpleveslerItem opleveslerItem = new OpleveslerItem("JENSENS BØFHUS",
                "Ria sus dolorest eratibu stiatur aut ad quae nonsequae corit et quatis ad quinda si bl", R.drawable.background_bil_vogn);
        OpleveslerItem opleveslerItem2 = new OpleveslerItem("FÅRUP SOMMERLAND",
                "Ria sus dolorest eratibad quae nonsequae corit et quat omnis ad qui audanda si bl", R.drawable.background_rabatter);
        OpleveslerItem opleveslerItem3 = new OpleveslerItem("BIG TEXT", "some small text about another things", R.drawable.background_log_in);
        ArrayList<OpleveslerItem> arrayList = new ArrayList<>();
        arrayList.add(opleveslerItem);
        arrayList.add(opleveslerItem2);
        arrayList.add(opleveslerItem3);
        return arrayList;
    }
}

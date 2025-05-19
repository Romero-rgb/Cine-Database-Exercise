    /**
     * Adds a {@link Studio} to the list of studios.
     *
     * @param studio the {@link Studio} object to add; must not be {@code null}
     * @throws IllegalArgumentException if the provided studio is {@code null}
     */
package dev.antonio.cine.util;

import dev.antonio.cine.model.*;

import java.util.*;

public class StudiosList {
    private List<Studio> studios;

    public int getSize() {
        return studios.size();
    }

    public List<Studio> getStudioList () {
        return new ArrayList<>(studios);
    }


    public void addStudio(Studio studio){
        if (studio == null) {
            throw new IllegalArgumentException(Constants.STUDIO_NULL);
        } else {
            studios.add(studio);
        }
    }

    public Studio lookForStudio(String name, String city) {
        for (Studio studio : studios) {
            if (studio.getName().equals(name) && studio.getCity().equals(city)) {
                return studio;
            }
        }
        return null;
    }

    public StudiosList filterByName(String name) {
        StudiosList filteredList = new StudiosList();
        for (Studio studio : studios) {
            if (studio.getName().equals(name)) {
               filteredList.addStudio(studio);
            }
        }
        return filteredList;
    }

    public StudiosList filterByCity(String city) {
        StudiosList filteredList = new StudiosList();
        for (Studio studio : studios) {
            if (studio.getCity().equals(city)) {
                filteredList.addStudio(studio);
            }
        }
        return filteredList;
    }

    public String listToString() {
        StringBuilder listStudio = new StringBuilder();
        for (Studio studio : studios) {
            listStudio.append(studio.studioToString());
        }

        return listStudio.toString();
    }

}

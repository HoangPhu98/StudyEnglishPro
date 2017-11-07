
package dictionary;

import java.util.ArrayList;

/**
 *
 * @author hoangphu
 */
public class ManageDictionary {
    ArrayList<Colection> colections;

    public ManageDictionary(ArrayList<Colection> colections) {
        this.colections = colections;
    }
    
    public ManageDictionary(){
        colections = new ArrayList();
    }

    public ArrayList<Colection> getColections() {
        return colections;
    }
    
    public void createNewColection(String name){
        Colection newColection = new Colection(name);
        colections.add(newColection);
    }
    
    public void addColection(Colection newColection){
        colections.add(newColection);
    }
    
    public void editNameCollection(String oldName, String newName){
        int i = 0;
        while(colections.get(i).getName().equalsIgnoreCase(oldName) && i < colections.size()){
            i++;
        }
        if(i < colections.size()){
            colections.get(i).setName(newName);
        }else{
            System.out.println("Not found word invalid!");
        }
    }
    
    public void removeCollection(String name){
        int i = 0;
        while(colections.get(i).getName().equalsIgnoreCase(name) && i < colections.size()){
            i++;
        }
        if(i < colections.size()){
            colections.remove(i);
        }else{
            System.out.println("Not found word invalid!");
        }
    }
    
    //Kiem tra ten cac colection
    public Colection getColectionByName(String nameColection){
        for(Colection oneColection : colections){
            if(nameColection.equalsIgnoreCase(oneColection.getName()))
                return oneColection;
        }
        return null;
    }
}

import java.util.*;

public class _2115Recipes {

    HashMap<String,List<String>>recipeIngMap = new HashMap();
    HashSet<String>recipeSet;
    Stack<String>result = new Stack<>();
    HashSet<String>supplySet;
    HashMap<String,Integer>visited = new HashMap();

    public boolean topologicSort(String parent){

        if(visited.get(parent)==2)return true;
        if(visited.get(parent)==1)return false;

        visited.put(parent,1);

        List<String>children = recipeIngMap.get(parent);

        ListIterator<String>iterator = children.listIterator();
        while(iterator.hasNext()){
            String child = iterator.next();
            if(recipeSet.contains(child)){
                if(!topologicSort(child))
                    return false;
            }else{
                if(!supplySet.contains(child))return false;
            }
        }
        visited.put(parent,2);
        result.push(parent);
        return true;
    }


    public List<String> findAllRecipes(String[] recipes,
                                       List<List<String>> ingredients,
                                       String[] supplies) {

        recipeSet = new HashSet<>(Arrays.asList(recipes));
        supplySet = new HashSet<>(Arrays.asList(supplies));

        for(int i=0;i<recipes.length;i++){
            recipeIngMap.put(recipes[i],ingredients.get(i));
            visited.put(recipes[i],0);
        }
        Iterator<String>ite = recipeSet.iterator();
        while(ite.hasNext()){
            String recipe = ite.next();
            if(visited.get(recipe)==0)
                topologicSort(recipe);
        }

        return result;
    }
}

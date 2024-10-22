import java.util.*;

class RandomizedSet {
    private Map<Integer, Integer> map;  // Maps element value -> its index in the list
    private List<Integer> list;         // Stores the elements
    private Random random;              // Random generator for getRandom()

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    // Inserts the element into the set if it's not present
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false; // Element is already present
        }
        // Add the element to the list and map
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    // Removes the element from the set if it exists
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false; // Element not found
        }
        int index = map.get(val);
        int lastElement = list.get(list.size() - 1);

        // Move the last element to the position of the element to delete
        list.set(index, lastElement);
        map.put(lastElement, index);

        // Remove the last element
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }
    
    // Returns a random element from the set
    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
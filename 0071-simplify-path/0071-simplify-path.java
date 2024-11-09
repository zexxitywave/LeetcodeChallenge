import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        for (String component : components) {
            if (component.equals("") || component.equals(".")) {
                // Ignore empty or current directory
                continue;
            } else if (component.equals("..")) {
                // Move up a directory (pop from stack if not empty)
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // It's a valid directory name, push onto the stack
                stack.push(component);
            }
        }

        // Build the simplified path
        StringBuilder simplifiedPath = new StringBuilder();
        for (String dir : stack) {
            simplifiedPath.append("/").append(dir);
        }

        // Edge case: if stack is empty, return "/"
        return simplifiedPath.length() > 0 ? simplifiedPath.toString() : "/";
    }
}

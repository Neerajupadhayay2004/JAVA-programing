
class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();

        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.isEmpty() || part.equals(".")) {
                continue;
            }

            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }

        // Build path in the correct order
        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.append("/").append(stack.removeLast());
        }

        return result.length() == 0 ? "/" : result.toString();
    }
}

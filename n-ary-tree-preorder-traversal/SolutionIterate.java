/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class SolutionIterate {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            if(root != null){
                result.add(root.val);
                for(int i = root.children.size() - 1; i >=0; i--){
                    stack.add(root.children.get(i));
                }
            }
        }
        return result;
    }
}
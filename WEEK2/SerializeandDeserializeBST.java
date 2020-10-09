public class SerializeandDeserializeBST {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";
            StringBuilder sb = new StringBuilder();
            serializePreorder(root, sb);
            return sb.toString().trim();
        }

        private void serializePreorder(TreeNode root, StringBuilder sb) {
            if (root == null) return;
            sb.append(root.val + " ");
            serializePreorder(root.left, sb);
            serializePreorder(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;
            String[] preorderString = data.split(" ");
            return deserializePreorder(preorderString, 0, preorderString.length - 1);
        }

        private TreeNode deserializePreorder(String[] preorderString, int start, int end) {

            if (end < start) return null;

            TreeNode root = new TreeNode(Integer.parseInt(preorderString[start]));


            int index = start;

            for (; index <= end; index++) {
                if (Integer.parseInt(preorderString[index]) > Integer.parseInt(preorderString[start])) {
                    break;
                }
            }

            root.left = deserializePreorder(preorderString, start + 1, index - 1);
            root.right = deserializePreorder(preorderString, index, end);

            return root;
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec ser = new Codec();
    // Codec deser = new Codec();
    // String tree = ser.serialize(root);
    // TreeNode ans = deser.deserialize(tree);
    // return ans;
}

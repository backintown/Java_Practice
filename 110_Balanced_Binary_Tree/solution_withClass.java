
class Solution {
  public boolean isBalanced(TreeNode root) {
      return helper(root).isBalanced;
  }
  
  public ResultType helper(TreeNode root) {
      if(root == null) {
          return new ResultType(true, 0);
      }
      
      ResultType left = helper(root.left);
      ResultType right = helper(root.right);
      
      if(!left.isBalanced || !right.isBalanced) {
          return new ResultType(false, -1);
      }
      
      if(Math.abs(left.maxDepth - right.maxDepth) > 1) {
          return new ResultType(false, -1);
      }
      
      return new ResultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
  }
  
  class ResultType{
      public boolean isBalanced;
      public int maxDepth;
      public ResultType(boolean isBalanced, int maxDepth) {
          this.isBalanced = isBalanced;
          this.maxDepth = maxDepth;
  }
}

}
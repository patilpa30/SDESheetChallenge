class Solution {
    public List<Integer> getRow(int rowIndex) {
        long ans = 1;
        List<Integer> res = new ArrayList<>();
        res.add((int) ans);
        rowIndex = rowIndex+1; //for 0 - based
        for(int col = 1; col <rowIndex;col++){
            ans = ans*(rowIndex - col);
            ans = ans/col;
            res.add((int) ans);
        }
        return res;
    }
}

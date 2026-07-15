class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> r = new ArrayList<>();
        int l=1<<n;
        for(int i=0;i<l;i++)r.add(i^(i>>1));
        return r;
    }
}
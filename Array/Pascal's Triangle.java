/*Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        //create a anslist
        List<List<Integer>>anslist=new ArrayList<>();
        //take a loop for each row
        for(int i=0; i<numRows; i++){
            //create a list to add pascal's' value 
            ArrayList<Integer>list=new ArrayList<>();

            //take a loop to add every value in i th row
            for(int j=0; j<=i; j++){

                if(j==0 || j==i){
                    list.add(1);//add 1 at start and at end
                }
                else{
                    //add the pascal's sum
                    //prev row's >>  pos ele + -1 pos ele
                    int sum = anslist.get(i-1).get(j-1) + anslist.get(i-1).get(j);

                    //add to list
                    list.add(sum);
                }
            }

            anslist.add(list);
        }

        return anslist;
        
    }
}

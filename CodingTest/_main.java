import java.util.*;
public class _main {
    
    public static void main(String[] args){
        String st = "20+4*2-8*12+10*2*3+2" ;
        String[] array = st.split("\\W");
        String[] cal = st.split("\\w+");
        System.out.println(Arrays.toString(cal));
        System.out.println(Arrays.toString(array));

        List<String> arrayList = new ArrayList<String>(Arrays.asList(array));
        List<String> arrayCal = new ArrayList<String>(Arrays.asList(cal));
        
        while(arrayCal.contains("*")){
            int index = arrayCal.indexOf("*");
            arrayCal.remove("*");
            Integer result = Integer.parseInt(arrayList.get(index-1))*Integer.parseInt(arrayList.get(index));
            arrayList.set(index-1, result.toString());
            arrayList.remove(index);

        }
        System.out.println(arrayList);
        System.out.println(arrayCal);
        int result = Integer.parseInt(arrayList.get(0));
        int index = 1;
        for(int i=1; i < arrayCal.size(); i++){
            if(arrayCal.get(i).equals("+")){
                result += Integer.parseInt(arrayList.get(index));
            }else{
                result -= Integer.parseInt(arrayList.get(index));
            }
            index ++;
        }

        System.out.println(result);
    }


}

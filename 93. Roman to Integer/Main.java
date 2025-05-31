import java.util.*;
public class Main {
    public int romanToInt(String s) {
        int ans=0;
        HashMap<Character,Integer> map=new HashMap<>(); 
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(i+1<s.length()){
                char ch2=s.charAt(i+1);
                if(ch=='I'){
                    if(ch2=='V'){
                        ans+=4;
                        i++;
                        continue;
                    }
                    if(ch2=='X'){
                        ans+=9;
                        i++;
                        continue;
                    }
                    else{
                        ans+=1;
                        continue;
                    }
                }
                else if(ch=='X'){
                    if(ch2=='L'){
                        ans+=40;
                        i++;
                        continue;
                    }
                    if(ch2=='C'){
                        ans+=90;
                        i++;
                        continue;
                    }
                    else{
                        ans+=10;
                        continue;
                    }
                }
                else if(ch=='C'){
                    if(ch2=='D'){
                        ans+=400;
                        i++;
                        continue;
                    }
                    if(ch2=='M'){
                        ans+=900;
                        i++;
                        continue;
                    }
                    else{
                        ans+=100;
                        continue;
                    }
                }
                else{
                    ans+=map.get(ch);
                    continue;
                }
            }
            else  ans+=map.get(ch);
        }
        return ans;
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Roman numeral: ");
        String roman = scanner.nextLine();
        int result = main.romanToInt(roman);
        System.out.println("The integer value is: " + result);
        scanner.close();
    }
}

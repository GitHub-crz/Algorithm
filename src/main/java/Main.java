import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (num[i] > num[i + 1]
                ) ans++;
            } else if (i == n - 1) {
                if (num[i] > num[i - 1]) ans++;
            } else {
                if (num[i] > num[i - 1] && num[i] > num[i + 1]) ans++;
            }
        }
        System.out.println(ans);
    }
}

//        HashMap<Integer,Integer> map=new HashMap<>();
//        for(int i=0;i<n;i++){
//            if(!map.containsKey(num[i])){
//                if(cal(num,num[i])>ans)ans=cal(num,num[i]);
//                map.put(num[i],1);
//            }
//        }
//        System.out.println(ans
//        );
//    }
//    static int cal(int[] num,int n){
//        int[] nums=new int[num.length];
//        for(int i=0;i<num.length;i++){
//            if(num[i]<n)nums[i]=0;
//            else
//            nums[i]=num[i];
//        }
//        int t=0;
//        int ans=0;
//
//        for(int i=0;i<num.length;i++){
//            if(nums[i]!=0)t=1;
//            else {
//                if(t==1)ans++;
//                t=0;
//            }
//        }
//        if(t==1)ans++;
//        return ans;
//
//    }
//}

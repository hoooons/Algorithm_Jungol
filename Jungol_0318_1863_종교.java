import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jungol_0318_1863_종교 {

	static int N,M;
    static int[] arr;
    static int[] rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
         
        arr = new int[N+1];
        rank = new int[N+1];
        make();
         
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }
        int res = 0;
        for(int i=1;i<=N;i++) {
        	if(i==arr[i])			// 최상위 부모의 갯수 == 종교의 갯수
        		res++;
        }
         
        System.out.println(res);
    }
     
    private static void make() {
        for(int i=1;i<N+1;i++) {
            arr[i]=i;
        }
    }
    private static int find(int a) {
        if(arr[a]==a) 
        	return a;
        return arr[a] = find(arr[a]);
    }
    private static void union(int a, int b) {		//랭크 설정 안해주면 시간초과
    	
    	if(rank[find(a)]<rank[find(b)])
    		arr[find(a)]=find(b);
    	else {
    		arr[find(b)]=find(a);
    		if(rank[find(a)]==rank[find(b)])
    			rank[find(a)]++;
    	}
    }
}

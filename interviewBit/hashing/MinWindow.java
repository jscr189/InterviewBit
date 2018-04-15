package interviewBit.hashing;

public class MinWindow {

	public static void main(String[] args) {
		System.out.println(minWindow("xiEjBOGeHIMIlslpQIZ6jERaAVoHUc9Hrjlv7pQpUSY8oHqXoQYWWll8Pumov89wXDe0Qx6bEjsNJQAQ0A6K21Z0BrmM96FWEdRG69M9CYtdBOrDjzVGPf83UdP3kc4gK0uHVKcPN4HPdccm9Qd2VfmmOwYCYeva6BSG6NGqTt1aQw9BbkNsgAjvYzkVJPOYCnz7U4hBeGpcJkrnlTgNIGnluj6L6zPqKo5Ui75tC0jMojhEAlyFqDs7WMCG3dmSyVoan5tXI5uq1IxhAYZvRQVHtuHae0xxwCbRh6S7fCLKfXeSFITfKHnLdT65K36vGC7qOEyyT0Sm3Gwl2iXYSN2ELIoITfGW888GXaUNebAr3fnkuR6VwjcsPTldQSiohMkkps0MH1cBedtaKNoFm5HbH15kKok6aYEVsb6wOH2w096OwEyvtDBTQwoLN87JriLwgCBBavbOAiLwkGGySk8nO8dLHuUhk9q7f0rIjXCsQeAZ1dfFHvVLupPYekXzxtWHd84dARvv4Z5L1Z6j8ur2IXWWbum8lCi7aErEcq41WTo8dRlRykyLRSQxVH70rUTz81oJS3OuZwpI1ifBAmNXoTfznG2MXkLtFu4SMYC0bPHNctW7g5kZRwjSBKnGihTY6BQYItRwLUINApd1qZ8W4yVG9tnjx4WyKcDhK7Ieih7yNl68Qb4nXoQl079Vza3SZoKeWphKef1PedfQ6Hw2rv3DpfmtSkulxpSkd9ee8uTyTvyFlh9G1Xh8tNF8viKgsiuCZgLKva32fNfkvW7TJC654Wmz7tPMIske3RXgBdpPJd5BPpMpPGymdfIw53hnYBNg8NdWAImY3otYHjbl1rqiNQSHVPMbDDvDpwy01sKpEkcZ7R4SLCazPClvrx5oDyYolubdYKcvqtlcyks3UWm2z7kh4SHeiCPKerh83bX0m5xevbTqM2cXC9WxJLrS8q7XF1nh", "dO4BRDaT1wd0YBhH88Afu7CI4fwAyXM8pGoGNsO1n8MFMRB7qugS9EPhCauVzj7h"));
	}
	
	public static String minWindow(String S, String T) {
		int hasFound[] = new int[256];
	    int toFind[] = new int[256];
	    int i, count;
	    for(i=0;i<T.length();i++){
	        toFind[T.charAt(i)]++;
	    }
	    count=0;
	    for(i=0;i<toFind.length;i++){
	        if(toFind[i]==0){
	            toFind[i] = -1;
	        }
	        else{
	            count+= toFind[i];
	        }
	    }
	    int start, end, len;
	    char ch;
	    start = end = 0;
	    
	    len = Integer.MAX_VALUE;
	    String window = null;
	    while(end != S.length()){
	        ch = S.charAt(end);
	        if(toFind[ch] == -1){
	            end++;
	            continue;
	        }
	        hasFound[ch]++;
	        if(hasFound[ch] <= toFind[ch]){
	            count--;
	        }
	        if(count==0){
	            while(toFind[S.charAt(start)] == -1 || hasFound[S.charAt(start)]> toFind[S.charAt(start)]){
	                if(toFind[S.charAt(start)] != -1)
	                    hasFound[S.charAt(start)]--;
	                start++;
	            }
	            if(end - start + 1 < len){
	                len = end - start + 1;
	                window = S.substring(start,start+len);
	            }
	        }
	        end++;
	    }
	    if(window == null){
	        return "";
	    }
	    return window;
    }

}

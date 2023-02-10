//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

vector<long long> printFirstNegativeInteger(long long int arr[],
                                             long long int n, long long int k);

// Driver program to test above functions
int main() {
    long long int t, i;
    cin >> t;
    while (t--) {
        long long int n;
        cin >> n;
        long long int arr[n];
        for (i = 0; i < n; i++) {
            cin >> arr[i];
        }
        long long int k;
        cin >> k;

        vector<long long> ans = printFirstNegativeInteger(arr, n, k);
        for (auto it : ans) cout << it << " ";
        cout << endl;
    }
    return 0;
}

// } Driver Code Ends


vector<long long> printFirstNegativeInteger(long long int arr[], long long int len, long long int k) {
        long long int i=0, j=0;
        vector<long long> res;
        deque<long long> negList;
        
        while(j < len){
            
            if(arr[j] < 0)
                negList.push_back(arr[j]);
                
            if(j-i+1 < k) // for 1st window when windowSize < k
                j++;
                
            else if(j-i+1 == k){
                if(negList.size() == 0)
                    res.push_back(0);
                    
                else {
                    res.push_back(negList.front());
                    
                    if(arr[i] == negList.front()) // 1st ele of window remove if neg
                        negList.pop_front();
                }
                
                i++;
                j++;
            }    
        }
        
        return res;
 }
 
 
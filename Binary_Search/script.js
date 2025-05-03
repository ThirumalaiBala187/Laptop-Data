
function binary_search(arr, num) {
    let start = 0;
    let mid = Math.floor(arr.length / 2);
    let idx=-1;
    for (let i = 0; i < arr.length / 2; i++) {
        if (arr[mid] == num) {
            idx = mid
            break;
        } else if (arr[start] == num) {
            idx = start;
            break;
        } else if (arr[mid] > num) {
            mid = Math.floor((start + mid) / 2);
        } else {
            start = mid + 1;
            mid = Math.floor((start + arr.length) / 2);
        }
    }
    console.log("Index : " + idx);
}


function selection_Sort(arr){
    for(let i=0;i<arr.length;i++){
        let idx=i;
        for(let j=i;j<arr.length;j++){
            // console.log("Array : " + arr)
            if(arr[i] > arr[j]){
                idx=j;
            }
        }
        let temp=arr[i];
        arr[i]=arr[idx];
        arr[idx]=temp;
        
    }
    console.log("Sorted Array : " , arr);
}






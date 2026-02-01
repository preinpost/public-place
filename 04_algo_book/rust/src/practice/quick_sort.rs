pub fn run() {

    let mut arr = vec![5, 7, 9, 0, 3, 1, 6, 2, 4, 8];
    let size = arr.len();
    
    quick_sort(&mut arr, 0, size - 1);
    println!("{:?}", arr);

}

fn quick_sort(arr: &mut Vec<i32>, start: usize, end: usize) {

    if start >= end {
        return;
    }

    let mut pivot = start;
    let mut left = start + 1;
    let mut right = end;

    while left <= right {
        
        while (left <= end) && (arr[left] <= arr[pivot] ) {
            left += 1;
        }

        while (right > start) && (arr[right] >= arr[pivot]) {
            right -= 1;
        }

        if left <= right {
            let tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        } else if left > right {
            let tmp = arr[pivot];
            arr[pivot] = arr[right];
            arr[right] = tmp;
        }
    }

    quick_sort(arr, start, right - 1);
    quick_sort(arr, right + 1, end);
}



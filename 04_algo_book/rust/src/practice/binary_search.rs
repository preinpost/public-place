use std::io::Read;

pub fn run() {
    let stdin = std::io::stdin();
    let mut buf = String::new();

    stdin.read_line(&mut buf).unwrap();

    let split = buf.split_ascii_whitespace().collect::<Vec<&str>>();

    let n = split[0].parse::<i32>().unwrap();
    let m = split[1].parse::<i32>().unwrap();

    let mut arr = Vec::with_capacity(n as usize);

    buf.clear();
    stdin.read_line(&mut buf).unwrap();
    
    arr = buf.split_ascii_whitespace().map(|x| x.parse::<i32>().unwrap()).collect();

    let rec_result = recursive_search(m, 0, n, &arr);
    println!("rec_result = {:?}", rec_result);

    let iter_result = iter_search(m, &arr);
    println!("iter_result = {:?}", iter_result);

}

fn recursive_search(target: i32, mut start: i32, mut end: i32, arr: &Vec<i32>) -> i32{
    let mid = (start + end) / 2;
    println!("mid = {:?}", mid);
    
    if arr[mid as usize] > target {
        return recursive_search(target, start, mid, arr);
    } else if arr[mid as usize] < target{
        return recursive_search(target, mid, end, arr);
    } else {
        return mid + 1;
    }

}

fn iter_search(target: i32, arr: &Vec<i32>) -> i32{
    let mut start = 0;
    let mut end = arr.len();
    
    while start <= end {
        let mid = (start + end) / 2;

        if arr[mid] > target {
            end = mid;
        } else if arr[mid] < target {
            start = mid;
        } else {
            return mid as i32 + 1;
        }
    }
    -1
}
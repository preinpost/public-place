use std::io::{stdin};

pub fn run() -> std::io::Result<()>{

    let stdin = stdin();

    let mut buf = String::new();
    stdin.read_line(&mut buf)?;

    let split: Vec<&str> = buf.split_ascii_whitespace().collect();
    
    let n = split[0].parse::<i32>().unwrap();
    let m = split[1].parse::<i32>().unwrap();
    
    let mut head_table: Vec<i32> = Vec::with_capacity((n + 1) as usize);
    for i in 0..=n {
        head_table.push(i);
    }
    
    for i in 0..m {
        buf.clear();
        stdin.read_line(&mut buf)?;
        let split: Vec<&str> = buf.split_ascii_whitespace().collect();

        let first  = split[0].parse::<i32>().unwrap();
        let second = split[1].parse::<i32>().unwrap();

        union(first, second, &mut head_table);
    }

    for i in 1..=n {
        print!("{:?} ",find(i, &mut head_table));
    }

    println!();
    println!("{:?}", head_table);


    return Ok(());

}

fn union(a: i32, b: i32, head_table: &mut Vec<i32>) {
    let result_a = find(a, head_table);
    let result_b = find(b, head_table);

    if result_a == result_b {
        return;
    }

    if result_a < result_b {
        head_table[result_b as usize] = result_a;
    } else {
        head_table[result_a as usize] = result_b;
    }
    
}

fn find(a: i32, head_table: &mut Vec<i32>) -> i32{
    if a != head_table[a as usize] {
        head_table[a as usize] = find(head_table[a as usize], head_table);
    }

    head_table[a as usize]
}
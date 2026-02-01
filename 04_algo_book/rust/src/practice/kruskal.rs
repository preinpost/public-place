pub fn run() -> std::io::Result<()> {

    let stdin = std::io::stdin();
    let mut buf = String::new();
    stdin.read_line(&mut buf)?;

    let split = buf.split_ascii_whitespace().collect::<Vec<&str>>();
    
    let v = split[0].parse::<i32>().unwrap();
    let e = split[1].parse::<i32>().unwrap();

    let mut edges: Vec<(i32, i32, i32)> = vec![];
    let mut root_table: Vec<i32> = Vec::with_capacity((v + 1) as usize);

    for i in 0..=v {
        root_table.push(i);
    }

    for _i in 0..e {
        buf.clear();
        stdin.read_line(&mut buf)?;
        let split = buf.split_ascii_whitespace().collect::<Vec<&str>>();
        edges.push(
            (
                split[2].parse::<i32>().unwrap(), // cost
                split[0].parse::<i32>().unwrap(), // start
                split[1].parse::<i32>().unwrap(), // end
            )
        )
    }

    edges.sort();

    let mut sum: i32 = 0;
    for item in edges {
        if find(item.1, &mut root_table) != find(item.2, &mut root_table) {
            sum += item.0;
            union(item.1, item.2, &mut root_table);
        }
    }

    println!("sum = {}", sum);

    Ok(())
}

fn find(x: i32, table: &mut Vec<i32>) -> i32 {
    if x != table[x as usize] {
        table[x as usize] = find(table[x as usize], table);
        return table[x as usize];
    }

    return table[x as usize];
}

fn union(a: i32, b: i32, table: &mut Vec<i32>) {
    let result_a = find(a, table);
    let result_b = find(b, table);

    if result_a != result_b {
        if result_a < result_b {
            table[result_b as usize] = result_a;
        } else {
            table[result_a as usize] = result_b;
        }
    }
}
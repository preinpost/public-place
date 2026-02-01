pub fn run() {

    println!("{}", (5, 5) > (3, 4)); // 5 > 3 is true
    println!("{}", (2, 2) > (3, 4)); // 2 > 3 is false
    println!("{}", (2, 5) > (3, 4)); // 2 > 3 is false
    println!("{}", (3, 5) > (3, 4)); // 3 == 3, then: 5 > 4 is true
    println!("{}", (5, 2) > (3, 4)); // 5 > 3 is true

}
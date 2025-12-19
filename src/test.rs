fn main() {
    println!("test");  // ERROR: println! in library code
    
    let x = vec![1, 2, 3];
    
    let val = x.get(10).unwrap();  // ERROR: unwrap()
    let api_key = "hardcoded-api-key";  // ERROR: hardcoded secret
    
}
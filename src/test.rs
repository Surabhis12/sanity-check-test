fn main() {
    // unwrap() without error handling
    let value = Some(5);
    let result = value.unwrap();
    
    // expect() without proper error handling
    let data = Some("test");
    let unwrapped = data.expect("Failed");
    
    // println! in library code
    println!("Debug output");
    
    
    // Hard-coded secret
    let api_key = "secret_key_123";
}
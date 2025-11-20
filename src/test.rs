use std::fs::File;
use std::io::Read;
use std::process::Command;
use std::time::SystemTime;
use std::{ptr, mem};

pub fn run_library_checks() {
    // ------------------------------
    // 1. unwrap() in library code
    // ------------------------------
    let v = Some(10);
    let _x = v.unwrap();

    // ------------------------------
    // 2. expect() in library code
    // ------------------------------
    let y = Some(20);
    let _y = y.expect("fail");

    // ------------------------------
    // 3. println! in library code
    // ------------------------------
    println!("Should not use println in library code");

    // ------------------------------
    // 4. Hard-coded secrets
    // ------------------------------
    let api_key = "myapikey123";
    let password = "mypassword";
    let access_token = "token123";

    // ------------------------------
    // 5. Weak randomness using SystemTime
    // ------------------------------
    let now = SystemTime::now();
    let random_token = format!("{}-token", now.elapsed().unwrap().as_millis());

    // ------------------------------
    // 6. Command injection
    // ------------------------------
    let _cmd = Command::new("sh").arg("-c").arg("ls -la").output();

    // ------------------------------
    // 7. excessive unsafe blocks
    // ------------------------------
    unsafe {
        let a = 10;
        let b = 20;
        let _c = a + b;
    }

    unsafe {
        let mut x = 5;
        x += 1;
    }

    unsafe {
        let mut y = 9;
        y *= 2;
    }

    // ------------------------------
    // 8. get_unchecked
    // ------------------------------
    let arr = vec![1, 2, 3];
    unsafe {
        let _unchecked = arr.get_unchecked(10);
    }

    // ------------------------------
    // 9. Box::from_raw
    // ------------------------------
    unsafe {
        let raw = Box::into_raw(Box::new(5));
        let _bx = Box::from_raw(raw); // potential double free
    }

    // ------------------------------
    // 10. Ignored Result
    // ------------------------------
    let _ = File::open("test.txt");
    let _ = File::open("another.txt");

    // ------------------------------
    // 11. mem::transmute
    // ------------------------------
    let num: u32 = 123;
    unsafe {
        let _trans = mem::transmute::<u32, f32>(num);
    }

    // ------------------------------
    // 12. needless clone
    // ------------------------------
    let s = "hello".to_string().clone().clone();

    // ------------------------------
    // 13. Weak XOR obfuscation
    // ------------------------------
    let data = 0xAB ^ 0x10;

    // ------------------------------
    // 14. Predictable temp files
    // ------------------------------
    let tmp = format!("/tmp/{}_file", std::process::id());

    // ------------------------------
    // 15. Box::leak
    // ------------------------------
    let _leaked = Box::leak(Box::new(123));

    // ------------------------------
    // 16. panic in non-test code
    // ------------------------------
    panic!("should not panic");

    // ------------------------------
    // 17. Raw pointer ops
    // ------------------------------
    unsafe {
        let mut x = 10;
        ptr::write(&mut x, 99);
        let _val = ptr::read(&x);
    }
}

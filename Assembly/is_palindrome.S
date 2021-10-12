.intel_syntax noprefix
.global _start
.text

.include "../../webserv/inc.S"

is_palindrome:
    push rbp
    mov rbp, rsp
    xor rcx, rcx
loop_string:
    mov al, [rdi + rcx]
    cmp al, 0
    je end_string
    inc rcx
    jmp loop_string
end_string:
    mov rdx, rcx
    dec rdx
    xor rcx, rcx
    lea rsi, [str2]
loop_cpy:
    mov al, [rdi + rdx]
    mov [rsi + rcx], al
    cmp rdx, 0
    jle check_cmp
    dec rdx
    inc rcx
    jmp loop_cpy
check_cmp:
    call strcmp
    leave
    ret

_start: 
    lea rdi, [str]
    mov rsi, 200
    call read_string
    lea rdi, [str]
    call is_palindrome 
    mov rdi, rax
    call print_hex
end:
    mov rax, 60
    syscall

.data
str: 
.fill 200, 1, 0
str2:
.fill 200, 1, 0


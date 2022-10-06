.intel_syntax noprefix
.global _start
.text

.include "../../webserv/inc.S"

caesar_encrypt:
    push rbp
    mov rbp, rsp
    xor rcx, rcx
    xor rax, rax
loop_caesar_encrypt:
    mov al, [rdi + rcx]
    cmp al, 0
    je end_caesar_encrypt
    cmp al, 0x41
    jb do_nothing_caesar_encrypt
    cmp al, 0x5a
    ja check_min 
    sub al, 0x41
    jmp encrypt_maj
check_min:
    cmp al, 0x61
    jb do_nothing_caesar_encrypt
    cmp al, 0x7a
    ja do_nothing_caesar_encrypt
    sub al, 0x61
encrypt_min:
    add rax, rsi
    mov rbx, 26
    xor rdx, rdx
    div rbx
    add rdx, 0x61
    mov rax, rdx
    jmp do_nothing_caesar_encrypt
encrypt_maj:
    add rax, rsi
    mov rbx, 26
    xor rdx, rdx
    div rbx
    add rdx, 0x41
    mov rax, rdx
do_nothing_caesar_encrypt:
    mov [rdi + rcx], al
    inc rcx
    jmp loop_caesar_encrypt 
end_caesar_encrypt:
    leave
    ret

_start:
    lea rdi, [input]
    mov rsi, 200
    call read_string
    call read_hex
    mov rsi, rax
    lea rdi, [input]
    call caesar_encrypt
    lea rdi, [input]
    call print_string
    mov rax, 60
    syscall
    

.data
input: 
.fill 200, 1, 0

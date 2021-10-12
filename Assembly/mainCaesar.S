.intel_syntax noprefix
.global _start
.text
.include "../inc.S"
.include "caesar.inc"

_start:
    xor rax, rax
    xor rdi, rdi

    //touch 
    xor rbx, rbx
    xor rdx, rdx
    xor rcx, rcx
    xor rsi, rsi

    lea rdi, [array]
    mov rsi, 200

    call read_string

    call read_hex
    mov rsi, rax

loop1:
    
    call caesar_func

    lea rdi, [array]
    call print_string

    jmp pexit

pexit:
    mov rax, 60
    syscall


.data

array:
.fill 200, 1, 0

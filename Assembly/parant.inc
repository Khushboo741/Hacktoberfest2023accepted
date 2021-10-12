isValid:
    push rbp
    mov rbp, rsp
    push rdi
    push rcx
    push r13

    xor rcx, rcx
    jmp parantCpt

parantCpt:
    mov dl, [rdi+rcx]

    cmp byte ptr[rdi+rcx], 0x28
    je plusParant

    cmp byte ptr[rdi+rcx], 0x29
    je lessParant

    cmp byte ptr[rdi+rcx], 0x0
    jne parantCpt
    jmp true_end

plusParant:
    inc r13
    inc rcx
    jmp parantCpt

lessParant:
    inc rcx
    sub r13, 1
    cmp r13, 0xff
    je false_end
    jmp parantCpt

false_end:
    mov rax, 1
    jmp str_end

true_end:
    cmp r13, 0x0
    jne false_end
    mov rax, 0

str_end:
    add rsp, 0x20
    pop rcx
    pop rdi
    pop r13
    leave
    ret

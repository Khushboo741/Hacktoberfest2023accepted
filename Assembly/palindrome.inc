palindrome:
    push rbp
    mov rbp, rsp
    leave
    ret

str_length:
    push rbp
    mov rbp, rsp
    push rdi
    push rcx
    xor rcx, rcx
    jmp length

length:
    inc rcx
    cmp byte ptr[rdi+rcx], 0x0
    jne length
    jmp str_end

str_end:
    mov rax, rcx
    add rsp, 0x20
    pop rcx
    pop rdi
    leave
    ret

isPalpair:
    push rbp
    mov rbp, rsp
    //chaine
    push rdi
    //taille/2
    push rsi
    //cpt
    push rcx
    push rdx
    push r12
    push r13
    
    sub rsp, 0x20
    xor rcx, rcx
    mov rdx, rsi
    mov r12, rsi

    mov r13, rdi

    jmp commp

commp:
    mov byte ptr dil, [r13+rcx]
    mov byte ptr sil, [r13+rdx]
    call strcmp
    cmp rax, 0x0
    jne commp_false
    inc rcx
    sub rdx, 1
    cmp rcx, r12
    jne commp
    jmp commp_end

commp_end:

    add rsp, 0x20
    pop rcx
    pop rdi
    leave
    ret

commp_false:
    mov rax, 1
    add rsp, 0x20
    pop rcx
    pop rdi
    leave
    ret

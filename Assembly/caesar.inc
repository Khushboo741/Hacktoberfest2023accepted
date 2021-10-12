caesar_func:
    push rbp
    mov rbp, rsp
    push rdi
    push rsi
    push rdx

    push rcx
    xor rcx, rcx
    jmp decalage

decalage:

    cmp byte ptr[rdi+rcx], 0x0
    
    cmp byte ptr[rdi+rcx], 0x0
    jne rot
    jmp caesar_end

rot:
    mov dl, [rdi+rcx]
    sub dl, sil
    mov [rdi+rcx], dl

    inc rcx
    jmp decalage


caesar_end:
    mov rax, rdi
    add rsp, 0x20
    pop rcx
    pop rdi
    pop rsi
    leave
    ret

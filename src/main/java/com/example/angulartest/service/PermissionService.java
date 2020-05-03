package com.example.angulartest.service;

import com.example.angulartest.dao.entities.PermissionEnt;
import com.example.angulartest.dto.PermissionDto;

import java.util.HashMap;
import java.util.List;

public interface PermissionService {
    /**
     * Lấy ra danh sách menu navbar của hệ thống theo vai trò
     * Ý tưởng của thuật toán
     * !! Vấn để:
     * (1)- Cần đẩy thằng con vào trong thằng cha
     * (2)- Đối với node anh em cần làm sao để tìm lại đối tượng cha Dto của nó mà thuật toán này chỉ lưu 1 giá trị cấp trên gần nhất nên ta dùng HashMap
     * (HashMap) cứ mỗi lần duyệt qua 1 phần tử sẽ bỏ vào map
     * Khi cần đẩy Node anh em vào cha đã có sẵn chỉ cần đọc map ra để lấy (cha Dto) rồi đẩy Node anh em vào thành con thăng cha
     * Ex:
     * - Node gốc: System - SystemDto
     * - Node lá tiếp theo: Account - SystemDto
     * - Bước đệm: Account - Account
     * - Node lá tiếp theo: Thêm tài khoản - AccountDto
     * - Bước đệm: Thêm tài khoản - Thêm tài khoản
     * - Node lá tiếp theo(Do thêm tài khoản không có thằng con nào)
     * nên sẽ duyệt tới node anh em
     * (Do bước đệm đang là Thêm tài khoản nên Node anh em Chi tiết tài khoản sẽ lấy cha của nó (2)) : Chi tiết tài khoản - AccountDto
     * <p>
     *
     * @return
     */
    List<PermissionDto> getNavigationBar(String role);

    /**
     * Đệ qui để duyệt theo chiều sâu lấy cây đơn vị các quyền
     *
     * @param subNavPermissionEnt
     * @return
     */
    PermissionDto recursivePermission(PermissionEnt subNavPermissionEnt, PermissionDto parentNavBarPermissionDto, HashMap<Long, PermissionDto> hashMap);

    /**
     * Thêm quyền con vào quyền cha
     *
     * @param subNavPermissionEnt
     * @param parentNavBarPermissionDto
     * @return
     */
    void addPermissionChildToPermissionParent(PermissionEnt subNavPermissionEnt, PermissionDto parentNavBarPermissionDto, HashMap<Long, PermissionDto> hashMap);
}

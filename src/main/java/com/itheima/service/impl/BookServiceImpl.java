package com.itheima.service.impl;

import com.itheima.entity.Book;
import com.itheima.mapper.BookMapper;
import com.itheima.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author root-akina
 * @since 2023-11-03
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

}

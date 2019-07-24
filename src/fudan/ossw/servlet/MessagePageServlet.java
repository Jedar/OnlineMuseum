package fudan.ossw.servlet;

import fudan.ossw.entity.Message;
import fudan.ossw.entity.Request;
import fudan.ossw.entity.User;
import fudan.ossw.service.FriendService;
import fudan.ossw.service.MessageService;
import fudan.ossw.service.UserService;
import fudan.ossw.service.impl.FriendServiceImpl;
import fudan.ossw.service.impl.MessageServiceImpl;
import fudan.ossw.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MessagePageServlet", value = "/jsp/message.jsp")
public class MessagePageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MessageService messageService = new MessageServiceImpl();
        UserService userService = new UserServiceImpl();
        int userID = ((User)request.getSession().getAttribute("user")).getUserID();
        List<Message> readMessages = messageService.getReadMessageList(userID);
        List<User> senderOfReadMessages = new ArrayList<>();
        for(Message message : readMessages) {
            senderOfReadMessages.add(userService.getUser(message.getSenderID()));
        }
        List<Message> unreadMessages = messageService.getUnreadMessageList(userID);
        List<User> senderOfUnreadMessages = new ArrayList<>();
        for(Message message : unreadMessages) {
            senderOfUnreadMessages.add(userService.getUser(message.getSenderID()));
        }
        List<Message> sendMessages = messageService.getSendMessageList(userID);
        List<User> receiverOfSendMessages = new ArrayList<>();
        for(Message message : sendMessages) {
            receiverOfSendMessages.add(userService.getUser(message.getReceiverID()));
        }
        FriendService friendService = new FriendServiceImpl();
        List<Request> requests = friendService.getRequestList(userID);
        List<User> senderOfRequests = new ArrayList<>();
        for(Request request1 : requests) {
            senderOfRequests.add(userService.getUser(request1.getSenderID()));
        }
        List<User> friends = friendService.getFriendsList(userID);
        List<User> recommendFriends = friendService.getRecommendFriends(userID);
        request.setAttribute("readMessages", readMessages);
        request.setAttribute("senderOfReadMessages", senderOfReadMessages);
        request.setAttribute("unreadMessages", unreadMessages);
        request.setAttribute("senderOfUnreadMessages", senderOfUnreadMessages);
        request.setAttribute("sendMessages", sendMessages);
        request.setAttribute("receiverOfSendMessages", receiverOfSendMessages);
        request.setAttribute("requests", requests);
        request.setAttribute("senderOfRequests", senderOfRequests);
        request.setAttribute("friends", friends);
        request.setAttribute("recommendFriends", recommendFriends);
        request.getRequestDispatcher("./message_page.jsp").forward(request, response);
    }
}

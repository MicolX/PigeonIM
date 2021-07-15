// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MessageProtocol.proto

package com.micolx.connector.protobuf;

public interface ChatMessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ChatMessage)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string msgID = 1;</code>
   * @return The msgID.
   */
  java.lang.String getMsgID();
  /**
   * <code>string msgID = 1;</code>
   * @return The bytes for msgID.
   */
  com.google.protobuf.ByteString
      getMsgIDBytes();

  /**
   * <code>string senderID = 2;</code>
   * @return The senderID.
   */
  java.lang.String getSenderID();
  /**
   * <code>string senderID = 2;</code>
   * @return The bytes for senderID.
   */
  com.google.protobuf.ByteString
      getSenderIDBytes();

  /**
   * <code>string recipientID = 3;</code>
   * @return The recipientID.
   */
  java.lang.String getRecipientID();
  /**
   * <code>string recipientID = 3;</code>
   * @return The bytes for recipientID.
   */
  com.google.protobuf.ByteString
      getRecipientIDBytes();

  /**
   * <code>int32 sequenceID = 4;</code>
   * @return The sequenceID.
   */
  int getSequenceID();

  /**
   * <code>string content = 5;</code>
   * @return The content.
   */
  java.lang.String getContent();
  /**
   * <code>string content = 5;</code>
   * @return The bytes for content.
   */
  com.google.protobuf.ByteString
      getContentBytes();

  /**
   * <code>string time = 6;</code>
   * @return The time.
   */
  java.lang.String getTime();
  /**
   * <code>string time = 6;</code>
   * @return The bytes for time.
   */
  com.google.protobuf.ByteString
      getTimeBytes();
}

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: NetCmdDataHeart.proto

package cn.com.yhcloud.netty;

public final class NetCmdDataHeartDP {
  private NetCmdDataHeartDP() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface NetCmdDataHeartDtoOrBuilder extends
      // @@protoc_insertion_point(interface_extends:dto.NetCmdDataHeartDto)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional string time = 1;</code>
     */
    String getTime();
    /**
     * <code>optional string time = 1;</code>
     */
    com.google.protobuf.ByteString
        getTimeBytes();

    /**
     * <code>optional int32 direction = 2;</code>
     */
    int getDirection();
  }
  /**
   * <pre>
   **
   * 心跳包数据格式
   * </pre>
   *
   * Protobuf type {@code dto.NetCmdDataHeartDto}
   */
  public  static final class NetCmdDataHeartDto extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:dto.NetCmdDataHeartDto)
      NetCmdDataHeartDtoOrBuilder {
    // Use NetCmdDataHeartDto.newBuilder() to construct.
    private NetCmdDataHeartDto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private NetCmdDataHeartDto() {
      time_ = "";
      direction_ = 0;
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private NetCmdDataHeartDto(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              String s = input.readStringRequireUtf8();

              time_ = s;
              break;
            }
            case 16: {

              direction_ = input.readInt32();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cn.com.yhcloud.netty.NetCmdDataHeartDP.internal_static_dto_NetCmdDataHeartDto_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cn.com.yhcloud.netty.NetCmdDataHeartDP.internal_static_dto_NetCmdDataHeartDto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto.class, cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto.Builder.class);
    }

    public static final int TIME_FIELD_NUMBER = 1;
    private volatile Object time_;
    /**
     * <code>optional string time = 1;</code>
     */
    public String getTime() {
      Object ref = time_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        time_ = s;
        return s;
      }
    }
    /**
     * <code>optional string time = 1;</code>
     */
    public com.google.protobuf.ByteString
        getTimeBytes() {
      Object ref = time_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        time_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int DIRECTION_FIELD_NUMBER = 2;
    private int direction_;
    /**
     * <code>optional int32 direction = 2;</code>
     */
    public int getDirection() {
      return direction_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getTimeBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, time_);
      }
      if (direction_ != 0) {
        output.writeInt32(2, direction_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getTimeBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, time_);
      }
      if (direction_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, direction_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto)) {
        return super.equals(obj);
      }
      cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto other = (cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto) obj;

      boolean result = true;
      result = result && getTime()
          .equals(other.getTime());
      result = result && (getDirection()
          == other.getDirection());
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + TIME_FIELD_NUMBER;
      hash = (53 * hash) + getTime().hashCode();
      hash = (37 * hash) + DIRECTION_FIELD_NUMBER;
      hash = (53 * hash) + getDirection();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * <pre>
     **
     * 心跳包 数据格式
     * </pre>
     *
     * Protobuf type {@code dto.NetCmdDataHeartDto}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:dto.NetCmdDataHeartDto)
        cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDtoOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return cn.com.yhcloud.netty.NetCmdDataHeartDP.internal_static_dto_NetCmdDataHeartDto_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return cn.com.yhcloud.netty.NetCmdDataHeartDP.internal_static_dto_NetCmdDataHeartDto_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto.class, cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto.Builder.class);
      }

      // Construct using cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        time_ = "";

        direction_ = 0;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return cn.com.yhcloud.netty.NetCmdDataHeartDP.internal_static_dto_NetCmdDataHeartDto_descriptor;
      }

      public cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto getDefaultInstanceForType() {
        return cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto.getDefaultInstance();
      }

      public cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto build() {
        cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto buildPartial() {
        cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto result = new cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto(this);
        result.time_ = time_;
        result.direction_ = direction_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto) {
          return mergeFrom((cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto other) {
        if (other == cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto.getDefaultInstance()) return this;
        if (!other.getTime().isEmpty()) {
          time_ = other.time_;
          onChanged();
        }
        if (other.getDirection() != 0) {
          setDirection(other.getDirection());
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private Object time_ = "";
      /**
       * <code>optional string time = 1;</code>
       */
      public String getTime() {
        Object ref = time_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          time_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>optional string time = 1;</code>
       */
      public com.google.protobuf.ByteString
          getTimeBytes() {
        Object ref = time_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          time_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string time = 1;</code>
       */
      public Builder setTime(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        time_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string time = 1;</code>
       */
      public Builder clearTime() {
        
        time_ = getDefaultInstance().getTime();
        onChanged();
        return this;
      }
      /**
       * <code>optional string time = 1;</code>
       */
      public Builder setTimeBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        time_ = value;
        onChanged();
        return this;
      }

      private int direction_ ;
      /**
       * <code>optional int32 direction = 2;</code>
       */
      public int getDirection() {
        return direction_;
      }
      /**
       * <code>optional int32 direction = 2;</code>
       */
      public Builder setDirection(int value) {
        
        direction_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 direction = 2;</code>
       */
      public Builder clearDirection() {
        
        direction_ = 0;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:dto.NetCmdDataHeartDto)
    }

    // @@protoc_insertion_point(class_scope:dto.NetCmdDataHeartDto)
    private static final cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto();
    }

    public static cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<NetCmdDataHeartDto>
        PARSER = new com.google.protobuf.AbstractParser<NetCmdDataHeartDto>() {
      public NetCmdDataHeartDto parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new NetCmdDataHeartDto(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<NetCmdDataHeartDto> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<NetCmdDataHeartDto> getParserForType() {
      return PARSER;
    }

    public cn.com.yhcloud.netty.NetCmdDataHeartDP.NetCmdDataHeartDto getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_dto_NetCmdDataHeartDto_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_dto_NetCmdDataHeartDto_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\025NetCmdDataHeart.proto\022\003dto\"5\n\022NetCmdDa" +
      "taHeartDto\022\014\n\004time\030\001 \001(\t\022\021\n\tdirection\030\002 " +
      "\001(\005B1\n\034cn.com.yhcloud.nettyB\021Net" +
      "CmdDataHeartDPb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_dto_NetCmdDataHeartDto_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_dto_NetCmdDataHeartDto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_dto_NetCmdDataHeartDto_descriptor,
        new String[] { "Time", "Direction", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}

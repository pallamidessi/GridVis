ifeq ($(shell uname -o 2>/dev/null),Msys)
	OS := MINGW
endif

ifneq ("$(OS)","")
	CXXFLAGS = -g -fmessage-length=0 -I.
else
	CXXFLAGS = -g -fmessage-length=0 -I./
endif

OBJS = cmdline.o config_file.o convert.o options_description.o\
	parsers.o positional_options.o utf8_codecvt_facet.o\
	value_semantic.o variables_map.o winmain.o

LIBS = 

TARGET = program_options.a

$(TARGET): $(OBJS)
	ar rcs $@ $^

%.o:%.cpp
	$(CXX) -c $(CXXFLAGS) $^

all: $(TARGET)
clean:
ifneq ("$(OS)","")
	-del $(OBJS) $(TARGET)
else
	rm -f $(OBJS) $(TARGET)
endif

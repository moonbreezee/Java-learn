# Java-learn

## git 提交大文件报错

git --no-optional-locks -c color.branch=false -c color.diff=false -c color.status=false -c diff.mnemonicprefix=false -c core.quotepath=false -c credential.helper=sourcetree push -v origin refs/heads/master:refs/heads/master
Pushing to git@github.com:qiuwww/Java-learn.git
remote: warning: File 书本/Head First Java.第二版中文完整高清版.pdf is 57.15 MB; this is larger than GitHub's recommended maximum file size of 50.00 MB  
remote: error: GH001: Large files detected. You may want to try Git Large File Storage - https://git-lfs.github.com.  
remote: error: Trace: 700964fc24411184b9529dfa1ce384c5  
remote: error: See http://git.io/iEPt8g for more information.  
remote: error: File 书本/java 从入门到精通（第 4 版）.pdf is 292.73 MB; this exceeds GitHub's file size limit of 100.00 MB  
To github.com:qiuwww/Java-learn.git
! [remote rejected] master -> master (pre-receive hook declined)
error: failed to push some refs to 'git@github.com:qiuwww/Java-learn.git'
Completed with errors, see above

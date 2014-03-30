meeting
=======

# JPA

## Entity定義

### UpdateDate / User などの共通で存在する属性は 基底Entityを用意したい
    EntityBaseクラスとして作成した。
### MeetingFormは関連テーブルだけどMeeting・MeetingTypeに対して一つなので、SecondaryTableで一つのEntitytにするか、もしくはMeeting一つにまとめたい
    要素壇。
### 議事録の中身はFetch.Lazyか

    またやるときに考える。
    
### 日付型に@Temporal
### Available系は @EnumTypeしたい

     booleanなのでいらなかった。
     
### 必ず存在するようなクエリはNamedQueryに掘り込んでしまう？findAllとか
### Default Value(UpdateDateとかAvailableとか)
    PrePersist -> 基底クラスに書いても動かなかった。
    DaoBaseに書く。ただし、この方法だとNativeQueryに対応できない。
### Metaフィールド
### ロック/排他更新制御の仕方. @Versionを日付で使えるか。
### どこまでをXMLで、どこからをアノテーションで。
### mappinig.xml が Hibernateスキーマになってる。JPAではどうか。
### DAO?
### Entityのdetachの制御方針

## JAX-RS
### Jacksonで日付フォーマットをカスタム 
### Enity <-> Dtoのマッピングがうざい
    
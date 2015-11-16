CREATE TABLE [dbo].[tab_master_opLience] (
  [funID] int IDENTITY(1, 1) NOT NULL,
  [opID] int NOT NULL,
  [mID] int NOT NULL,
  [nm] varchar(50) COLLATE Chinese_PRC_CI_AS NULL,
  [infoID] varchar(8) COLLATE Chinese_PRC_CI_AS NULL,
  CONSTRAINT [PK__tab_mast__A8CB69843B40CD36] PRIMARY KEY CLUSTERED ([funID])
)
ON [PRIMARY]
GO